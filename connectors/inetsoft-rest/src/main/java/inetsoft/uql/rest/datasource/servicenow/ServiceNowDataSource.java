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
package inetsoft.uql.rest.datasource.servicenow;

import inetsoft.uql.rest.auth.AuthType;
import inetsoft.uql.rest.json.EndpointJsonDataSource;
import inetsoft.uql.tabular.*;
import inetsoft.util.Tool;
import inetsoft.util.credential.CredentialType;
import org.w3c.dom.Element;

import java.io.PrintWriter;
import java.util.Objects;

@View(vertical = true, value = {
   @View1("instance"),
   @View1("URL"),
   @View1(value = "useCredentialId", visibleMethod = "supportToggleCredential"),
   @View1(value = "credentialId", visibleMethod = "isUseCredentialId"),
   @View1(value = "user", visibleMethod = "useCredential"),
   @View1(value = "password", visibleMethod = "useCredential")
})
public class ServiceNowDataSource extends EndpointJsonDataSource<ServiceNowDataSource> {
   static final String TYPE = "Rest.ServiceNow";

   public ServiceNowDataSource() {
      super(TYPE, ServiceNowDataSource.class);
      setAuthType(AuthType.BASIC);
   }

   @Override
   protected CredentialType getCredentialType() {
      return CredentialType.PASSWORD;
   }

   @Property(label = "Instance", required = true)
   public String getInstance() {
      return instance;
   }

   public void setInstance(String instance) {
      this.instance = instance;
   }

   @Property(label = "URL")
   @PropertyEditor(enabled = false, dependsOn = "instance")
   @Override
   public String getURL() {
      StringBuilder url = new StringBuilder("https://");

      if(instance == null) {
         url.append("[Instance]");
      }
      else {
         url.append(instance);
      }

      return url.append(".service-now.com/api").toString();
   }

   @Override
   public void setURL(String url) {
      // no-op
   }

   @Property(label = "User", required = true)
   @Override
   public String getUser() {
      return super.getUser();
   }

   @Property(label = "Password", required = true, password = true)
   @Override
   public String getPassword() {
      return super.getPassword();
   }

   @Override
   public HttpParameter[] getQueryHttpParameters() {
      HttpParameter param = new HttpParameter();
      param.setType(HttpParameter.ParameterType.HEADER);
      param.setName("Accept");
      param.setValue("application/json");
      return new HttpParameter[] { param };
   }

   @Override
   public void setQueryHttpParameters(HttpParameter[] parameters) {
      // no-op
   }

   @Override
   public void writeContents(PrintWriter writer) {
      super.writeContents(writer);

      if(instance != null) {
         writer.format("<instance><![CDATA[%s]]></instance>%n", instance);
      }
   }

   @Override
   public void parseContents(Element root) throws Exception {
      super.parseContents(root);
      instance = Tool.getChildValueByTagName(root, "instance");
   }

   @Override
   protected String getTestSuffix() {
      return "/sn_sc/servicecatalog/catalogs";
   }

   @Override
   public boolean equals(Object o) {
      if(this == o) {
         return true;
      }

      if(!(o instanceof ServiceNowDataSource)) {
         return false;
      }

      if(!super.equals(o)) {
         return false;
      }

      ServiceNowDataSource that = (ServiceNowDataSource) o;
      return Objects.equals(instance, that.instance);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), instance);
   }

   private String instance;
}
