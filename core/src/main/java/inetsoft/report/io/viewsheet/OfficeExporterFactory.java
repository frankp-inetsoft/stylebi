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
package inetsoft.report.io.viewsheet;

import inetsoft.report.io.viewsheet.excel.WSExporter;

import java.io.OutputStream;

/**
 * Factory interface for classes that create exporters for MS Office file formats.
 */
public interface OfficeExporterFactory {
   AbstractVSExporter createExcelExporter(OutputStream stream);

   AbstractVSExporter createPowerpointExporter(OutputStream stream);

   WSExporter createWorksheetExporter();

   default WSExporter createWorksheetExporter(int row, int col) {
      return createWorksheetExporter();
   }

   static OfficeExporterFactory getInstance() {
      try {
         Class<?> clazz = OfficeExporterFactory.class.getClassLoader()
            .loadClass("inetsoft.report.io.viewsheet.PoiOfficeExporterFactory");
         return (OfficeExporterFactory) clazz.getConstructor().newInstance();
      }
      catch(Exception e) {
         throw new RuntimeException("Failed to create factory instance", e);
      }
   }
}
