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
package inetsoft.util.health;

import inetsoft.util.SingletonManager;

public class HealthService {
   public HealthService() {
      cacheSwapHealthService = CacheSwapHealthService.getInstance();
      deadlockHealthService = DeadlockHealthService.getInstance();
      outOfMemoryHealthService = OutOfMemoryHealthService.getInstance();
      reportFailureHealthService = ReportFailureHealthService.getInstance();
      schedulerHealthService = SchedulerHealthService.getInstance();
   }

   public static HealthService getInstance() {
      return SingletonManager.getInstance(HealthService.class);
   }

   public HealthStatus getStatus() {
      return new HealthStatus(
         cacheSwapHealthService.getStatus(),
         deadlockHealthService.getStatus(),
         outOfMemoryHealthService.getStatus(),
         reportFailureHealthService.getStatus(),
         schedulerHealthService.getStatus());
   }

   private final CacheSwapHealthService cacheSwapHealthService;
   private final DeadlockHealthService deadlockHealthService;
   private final OutOfMemoryHealthService outOfMemoryHealthService;
   private final ReportFailureHealthService reportFailureHealthService;
   private final SchedulerHealthService schedulerHealthService;
}
