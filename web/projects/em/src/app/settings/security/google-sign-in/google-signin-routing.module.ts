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
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GoogleSignInResolver } from "./google-sign-in-resolver.service";
import { GoogleSignInSettingComponent } from "./google-sign-in-setting/google-sign-in-setting.component";

const routes: Routes = [
   {
      path: "",
      component: GoogleSignInSettingComponent,
      resolve: {
         model: GoogleSignInResolver
      }
   }
];

@NgModule({
   imports: [RouterModule.forChild(routes)],
   exports: [RouterModule],
   providers: [GoogleSignInResolver]
})
export class GoogleSignInRoutingModule {
}
