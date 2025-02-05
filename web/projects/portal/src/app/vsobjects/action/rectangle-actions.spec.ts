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
import { TestUtils } from "../../common/test/test-utils";
import { ComposerContextProviderFactory, ViewerContextProviderFactory } from "../context-provider.service";
import { RectangleActions } from "./rectangle-actions";

describe("RectangleActions", () => {
   const createModel = () => TestUtils.createMockVSRectangleModel("Rectangle1");

   it("check status of menu actions of rectangle in composer", () => {
      const expectedMenu = [
         [
            { id: "rectangle properties", visible: true },
            { id: "rectangle show-format-pane", visible: true },
            { id: "rectangle lock", visible: true },
            { id: "rectangle unlock", visible: false }
         ],
         [
            { id: "rectangle annotate", visible: false }
         ],
         [
            { id: "vs-object copy", visible: true },
            { id: "vs-object cut", visible: true },
            { id: "vs-object remove", visible: true },
            { id: "vs-object group", visible: true },
            { id: "vs-object ungroup", visible: true }
         ],
         [
            { id: "vs-object bring-forward", visible: true },
            { id: "vs-object bring-to-front", visible: true },
            { id: "vs-object send-backward", visible: true },
            { id: "vs-object send-to-back", visible: true }
         ],
         [
            { id: "annotation edit", visible: false },
            { id: "annotation format", visible: false },
            { id: "annotation remove", visible: false }
         ]
      ];

      const model = createModel();
      const actions = new RectangleActions(model, ComposerContextProviderFactory());
      const menuActions = actions.menuActions;

      expect(menuActions).toMatchSnapshot();

      //Bug #20813 should not display lock/unlock when in group container
      model.container = "group1";
      model.containerType = "VSGroupContainer";
      expect(menuActions[0].actions[2].visible()).toBe(false);
      model.locked = true;
      expect(menuActions[0].actions[3].visible()).toBe(false);
   });

   it("check status of menu actions of rectangle in viewer and preview", () => {
      const expectedMenu = [
         [
            { id: "rectangle properties", visible: false },
            { id: "rectangle show-format-pane", visible: false },
            { id: "rectangle lock", visible: false },
            { id: "rectangle unlock", visible: false }
         ],
         [
            { id: "rectangle annotate", visible: false }
         ],
         [
            { id: "vs-object copy", visible: false },
            { id: "vs-object cut", visible: false },
            { id: "vs-object remove", visible: false },
            { id: "vs-object group", visible: false },
            { id: "vs-object ungroup", visible: false }
         ],
         [
            { id: "vs-object bring-forward", visible: false },
            { id: "vs-object bring-to-front", visible: false },
            { id: "vs-object send-backward", visible: false },
            { id: "vs-object send-to-back", visible: false }
         ],
         [
            { id: "annotation edit", visible: false },
            { id: "annotation format", visible: false },
            { id: "annotation remove", visible: false }
         ]
      ];

      //check status in viewer
      const model = createModel();
      const actions1 = new RectangleActions(model, ViewerContextProviderFactory(false));
      const menuActions1 = actions1.menuActions;

      expect(menuActions1).toMatchSnapshot();

      //check status in preview
      const model2 = createModel();
      const actions2 = new RectangleActions(model2, ViewerContextProviderFactory(true));
      const menuActions2 = actions2.menuActions;

      expect(menuActions2).toMatchSnapshot();
   });

   //Bug #19986 should not display menu action when as data tip component
   it("should not display menu action when as data tip component", () => {
      const dataTipService: any = { isDataTip: jest.fn() };
      dataTipService.isDataTip.mockImplementation(() => true);
      const model = createModel();
      const actions = new RectangleActions(model, ViewerContextProviderFactory(false), false, null, dataTipService);
      const menuActions = actions.menuActions;

      expect(menuActions.length).toBe(0);
   });
});