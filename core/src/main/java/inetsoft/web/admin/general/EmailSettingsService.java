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
package inetsoft.web.admin.general;

import inetsoft.sree.SreeEnv;
import inetsoft.util.Tool;
import inetsoft.util.audit.ActionRecord;
import inetsoft.web.admin.general.model.EmailSettingsModel;
import inetsoft.web.viewsheet.AuditUser;
import inetsoft.web.viewsheet.Audited;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class EmailSettingsService {
   public EmailSettingsModel getModel() {
      boolean historyEnabled = "true".equalsIgnoreCase(SreeEnv.getProperty("mail.history.enabled"));

      return EmailSettingsModel.builder()
         .smtpHost(SreeEnv.getProperty("mail.smtp.host"))
         .ssl(SreeEnv.getBooleanProperty("mail.ssl"))
         .tls(SreeEnv.getBooleanProperty("mail.tls"))
         .jndiUrl(SreeEnv.getProperty("mail.jndi.url"))
         .smtpAuthentication("true".equals(SreeEnv.getProperty("mail.smtp.auth")))
         .smtpUser(SreeEnv.getProperty("mail.smtp.user"))
         .smtpSecretId(Tool.isCloudSecrets() ? SreeEnv.getProperty("mail.smtp.pass") : null)
         .smtpPassword(!Tool.isCloudSecrets() ? SreeEnv.getPassword("mail.smtp.pass") : null)
         .fromAddress(SreeEnv.getProperty("mail.from.address"))
         .deliveryMailSubjectFormat(SreeEnv.getProperty("mail.subject.format"))
         .notificationMailSubjectFormat(SreeEnv.getProperty("mail.notification.subject.format"))
         .historyEnabled(historyEnabled)
         .secretIdVisible(Tool.isCloudSecrets())
         .build();
   }

   @Audited(
      actionName = ActionRecord.ACTION_NAME_EDIT,
      objectName = "General-Mail",
      objectType = ActionRecord.OBJECT_TYPE_EMPROPERTY
   )
   public void setModel(EmailSettingsModel model,
                        @SuppressWarnings("unused") @AuditUser Principal principal)
      throws Exception
   {
      SreeEnv.setProperty("mail.smtp.auth", model.smtpAuthentication() + "");

      if(model.smtpAuthentication()) {
         SreeEnv.setProperty("mail.smtp.user", model.smtpUser());
         SreeEnv.setPassword(
            "mail.smtp.pass", Tool.isCloudSecrets() ? model.smtpSecretId() :model.smtpPassword());
      }

      SreeEnv.setProperty("mail.smtp.host", model.smtpHost());
      SreeEnv.setProperty("mail.ssl", model.ssl() + "");
      SreeEnv.setProperty("mail.tls", model.tls() + "");
      SreeEnv.setProperty("mail.jndi.url", model.jndiUrl());
      SreeEnv.setProperty("mail.from.address", model.fromAddress());
      SreeEnv.setProperty("mail.subject.format", model.deliveryMailSubjectFormat());
      SreeEnv.setProperty("mail.notification.subject.format", model.notificationMailSubjectFormat());
      SreeEnv.setProperty("mail.history.enabled", model.historyEnabled() + "");
      SreeEnv.save();
   }
}
