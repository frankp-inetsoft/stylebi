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

package inetsoft.util.credential;

import inetsoft.util.Tool;
import org.w3c.dom.Element;

import java.io.PrintWriter;

public abstract class AbstractLocalCredential extends AbstractCredential {
   @Override
   public void writeXML(PrintWriter writer) {
      writer.write("<PasswordCredential class=\"" + this.getClass().getName() + "\">");
      writeContent(writer);
      writer.write("</PasswordCredential>");
   }

   abstract void writeContent(PrintWriter writer);

   @Override
   public void parseXML(Element elem) throws Exception {
   }

   protected String getDecryptPassword(Element elem) {
      if(elem == null) {
         return null;
      }

      String value = Tool.getValue(elem);
      return value == null ? null : Tool.decryptPassword(value);
   }
}
