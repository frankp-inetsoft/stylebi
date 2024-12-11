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
package inetsoft.web.health;

import inetsoft.util.health.ReportFailureHealthService;
import inetsoft.util.health.ReportFailureStatus;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ReportFailureHealthIndicator implements HealthIndicator {
   public ReportFailureHealthIndicator() {
      this.service = ReportFailureHealthService.getInstance();
   }

   @Override
   public Health health() {
      ReportFailureStatus status = service.getStatus();

      if(status.isExcessiveFailures()) {
         LoggerFactory.getLogger(getClass()).error(
            "ReportFailureHealthIndicator DOWN: failureCount={}", status.getFailureCount());
         return Health.down().withDetail("failureCount", status.getFailureCount()).build();
      }

      return Health.up().build();
   }

   private final ReportFailureHealthService service;
}
