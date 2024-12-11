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
package inetsoft.web.portal.data;

import inetsoft.uql.xmla.XMLADataSource;
import inetsoft.util.Tool;
import inetsoft.web.portal.model.database.cube.xmla.DomainModel;

public class DataSourceXmlaDefinition extends BaseDataSourceDefinition {
   public DataSourceXmlaDefinition() {
   }

   public DataSourceXmlaDefinition(XMLADataSource xmlaDataSource) {
      setName(xmlaDataSource.getName());
      datasource = xmlaDataSource.getDataSource();
      datasourceName = xmlaDataSource.getDatasourceName();
      datasourceInfo = xmlaDataSource.getDatasourceInfo();
      catalogName = xmlaDataSource.getCatalogName();
      url = xmlaDataSource.getURL();
      login = xmlaDataSource.isRequireLogin();
      setDescription(xmlaDataSource.getDescription());
      String path = xmlaDataSource.getFullName();
      setParentPath(path.lastIndexOf("/") > 0 ?
         path.substring(0, path.lastIndexOf("/")) : "");

      if(xmlaDataSource.isUseCredential()) {
         credentialId = xmlaDataSource.getCredentialId();
         useCredential = true;
      }
      else {
         user = xmlaDataSource.getUser();
         password = xmlaDataSource.getPassword();
      }
   }

   public String getDatasource() {
      return datasource;
   }

   public void setDatasource(String datasource) {
      this.datasource = datasource;
   }

   public String getDatasourceName() {
      return datasourceName;
   }

   public void setDatasourceName(String datasourceName) {
      this.datasourceName = datasourceName;
   }

   public String getDatasourceInfo() {
      return datasourceInfo;
   }

   public void setDatasourceInfo(String datasourceInfo) {
      this.datasourceInfo = datasourceInfo;
   }

   public String getCatalogName() {
      return catalogName;
   }

   public void setCatalogName(String catalogName) {
      this.catalogName = catalogName;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isUseCredential() {
      return useCredential;
   }

   public void setUseCredential(boolean useCredential) {
      this.useCredential = useCredential;
   }

   public String getCredentialId() {
      return credentialId;
   }

   public void setCredentialId(String credentialId) {
      this.credentialId = credentialId;
   }

   public boolean isCredentialVisible() {
      return credentialVisible;
   }

   public void setCredentialVisible(boolean credentialVisible) {
      this.credentialVisible = credentialVisible;
   }

   public boolean isLogin() {
      return login;
   }

   public void setLogin(boolean login) {
      this.login = login;
   }

   public DomainModel getDomain() {
      return domain;
   }

   public void setDomain(DomainModel domain) {
      this.domain = domain;
   }

   public void updateDataSource(XMLADataSource source) {
      String sourceName = "/".equals(getParentPath()) || Tool.isEmptyString(getParentPath()) ?
         getName() : getParentPath() + getName();

      if(Tool.equals(source.isUseCredential(), useCredential)) {
         source.initCredential(useCredential);
      }

      source.setName(sourceName);
      source.setDataSource(datasource);
      source.setDatasourceName(datasourceName);
      source.setDatasourceInfo(datasourceInfo);
      source.setCatalogName(catalogName);
      source.setURL(url);
      source.setUser(user);
      source.setPassword(password);
      source.setCredentialId(credentialId);
      source.setRequireLogin(login);
      source.setDescription(getDescription());
   }

   private String datasource = null;
   private String datasourceName = null;
   private String datasourceInfo = null;
   private String catalogName = null;
   private String url = null;
   private String user = null;
   private String password = null;
   private boolean useCredential = false;
   private String credentialId = null;
   private boolean credentialVisible = Tool.isCloudSecrets();
   private boolean login = false;
   private DomainModel domain;
}
