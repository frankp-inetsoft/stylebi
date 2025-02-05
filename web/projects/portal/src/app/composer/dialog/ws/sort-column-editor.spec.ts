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
import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { SortColumnEditorModel } from "../../data/ws/sort-column-editor-model";
import { SortColumnEditor } from "./sort-column-editor.component";

describe("Sort Column Editor Unit Test", () => {
   const createModel: () => SortColumnEditorModel = () => {
      return {
         availableColumns: ["CITY", "STATE"],
         columnDescriptions: ["CITY", "STATE"],
         aliasMap: {},
         captionMap: {},
         selectedColumns: ["CITY", "STATE"],
         orders: [1, 1],
         originalNames: [],
         rangeColumns: []
      };
   };

   let fixture: ComponentFixture<SortColumnEditor>;
   let sortColumnEditor: SortColumnEditor;

   beforeEach(async(() => {
      TestBed.configureTestingModule({
         imports: [
            FormsModule, ReactiveFormsModule, NgbModule
         ],
         declarations: [
            SortColumnEditor
         ]
      });
      TestBed.compileComponents();

      fixture = TestBed.createComponent(SortColumnEditor);
      sortColumnEditor = <SortColumnEditor> fixture.componentInstance;
      sortColumnEditor.model = createModel();
      fixture.componentInstance.ngOnChanges(null);
      fixture.detectChanges();
   }));

   //Bug #19015 change sort type of one column when has defined multiple sort columns
   it("check change one column sort type", () => {
      fixture.detectChanges();
      let sortRadios = fixture.nativeElement.querySelectorAll("input[type=radio]");

      expect(sortRadios[0].getAttribute("ng-reflect-model")).toBe("1");
      expect(sortRadios[1].getAttribute("ng-reflect-model")).toBe("1");
      expect(sortRadios[2].getAttribute("ng-reflect-model")).toBe("1");
      expect(sortRadios[3].getAttribute("ng-reflect-model")).toBe("1");

      sortRadios[1].click();
      fixture.detectChanges();
      sortRadios = fixture.nativeElement.querySelectorAll("input[type=radio]");
      expect(sortRadios[0].getAttribute("ng-reflect-model")).toBe("2");
      expect(sortRadios[1].getAttribute("ng-reflect-model")).toBe("2");
      expect(sortRadios[2].getAttribute("ng-reflect-model")).toBe("1");
      expect(sortRadios[3].getAttribute("ng-reflect-model")).toBe("1");
   });
});
