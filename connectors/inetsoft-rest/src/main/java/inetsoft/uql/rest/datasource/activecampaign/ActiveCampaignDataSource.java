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
package inetsoft.uql.rest.datasource.activecampaign;

import inetsoft.uql.rest.auth.AuthType;
import inetsoft.uql.rest.json.EndpointJsonDataSource;
import inetsoft.uql.tabular.*;
import inetsoft.util.credential.CredentialType;

@View(vertical = true, value = {
   @View1("URL"),
   @View1(value = "useCredentialId", visibleMethod = "supportToggleCredential"),
   @View1(value = "credentialId", visibleMethod = "isUseCredentialId"),
   @View1(value ="apiToken", visibleMethod = "useCredential")
})
public class ActiveCampaignDataSource extends EndpointJsonDataSource<ActiveCampaignDataSource> {
   public static final String TYPE = "Rest.ActiveCampaign";

   public ActiveCampaignDataSource() {
      super(TYPE, ActiveCampaignDataSource.class);
      setURL("https://[Account Name].api-us1.com/api");
      setAuthType(AuthType.NONE);
   }

   @Override
   protected CredentialType getCredentialType() {
      return CredentialType.API_TOKEN;
   }

   @Property(label = "API Token", required = true)
   @PropertyEditor(dependsOn = "useCredentialId")
   public String getApiToken() {
      HttpParameter param = getHttpParameter("Api-Token", HttpParameter.ParameterType.HEADER);
      return param != null ? param.getValue() : null;
   }

   public void setApiToken(String apiToken) {
      setHttpParameter("Api-Token", apiToken, HttpParameter.ParameterType.HEADER);
   }

   @Override
   protected String getTestSuffix() {
      return "/3/users/me";
   }
}