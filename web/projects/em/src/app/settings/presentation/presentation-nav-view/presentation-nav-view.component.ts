/*
 * This file is part of StyleBI.
 * Copyright (C) 2024  InetSoft Technology
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { AppInfoService } from "../../../../../../shared/util/app-info.service";
import { AuthorizationService } from "../../../authorization/authorization.service";
import { PageHeaderService } from "../../../page-header/page-header.service";
import { Secured } from "../../../secured";

interface Link {
   path: string;
   name: string;
   label: string;
}

@Secured({
   route: "/settings/presentation",
   label: "Presentation"
})
@Component({
   selector: "em-presentation-nav-view",
   templateUrl: "./presentation-nav-view.component.html",
   styleUrls: ["./presentation-nav-view.component.scss"]
})
export class PresentationNavViewComponent implements OnInit {

   readonly links: Link[] = [
      { path: "/settings/presentation/settings", name: "settings", label: "_#(js:Global Settings)" },
      { path: "/settings/presentation/org-settings", name: "org-settings", label: "_#(js:Organization Settings)" },
      { path: "/settings/presentation/themes", name: "themes", label: "_#(js:Themes)" }
   ];
   visibleLinks: Link[];

   constructor(private pageTitle: PageHeaderService, private authzService: AuthorizationService,
               private http: HttpClient, private appInfoService: AppInfoService)
   {
      appInfoService.isEnterprise().subscribe((isEnterprise) => {
         if(isEnterprise) {
            authzService.getPermissions("/settings/presentation").subscribe(permissions => {
               this.http.get("../api/em/navbar/isMultiTenant").subscribe((isMultiTenant: boolean) =>
               {
                  this.visibleLinks =
                     this.renameOrgSettings(this.links.filter(link => permissions.permissions[link.name]), isMultiTenant);
               })
            });
         }
         else {
            this.visibleLinks = [
               { path: "/settings/presentation/settings", name: "settings", label: "_#(js:Global Settings)" }];
         }
      })
   }

   ngOnInit(): void {
      this.pageTitle.title = "_#(js:Presentation)";
   }

   renameOrgSettings(visibleLinks: Link[], isMultiTenant: boolean): Link[] {
      let noOrgScope = true;

      for(let i = 0; i < visibleLinks.length; i ++) {
         let link = visibleLinks[i];

         if(link.name == "org-settings") {
            if(!isMultiTenant) {
               visibleLinks.splice(i, 1);
               i --;
            }
            else {
               noOrgScope = false;
            }
         }
      }

      if(noOrgScope) {
         for(let i = 0; i < visibleLinks.length; i ++) {
            let link = visibleLinks[i];

            if(link.name == "settings") {
               link.label = "_#(js:Settings)"
            }
         }
      }

      return visibleLinks;
   }
}
