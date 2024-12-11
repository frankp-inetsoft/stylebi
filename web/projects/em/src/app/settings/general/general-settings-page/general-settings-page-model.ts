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
import { DataSpaceSettingsModel } from "../data-space-settings-view/data-space-settings-model";
import { LicenseKeySettingsModel } from "../license-key-settings-view/license-key-settings-model";
import { LocalizationSettingsModel } from "../localization-settings-view/localization-settings-model";
import { MVSettingsModel } from "../mv-settings-view/mv-settings-model";
import { CacheSettingsModel } from "../cache-settings-view/cache-settings-model";
import { EmailSettingsModel } from "../email-settings-view/email-settings-model";
import { PerformanceSettingsModel } from "../performance-settings-view/performance-settings-model";

export interface GeneralSettingsPageModel {
   dataSpaceSettingsModel?: DataSpaceSettingsModel;
   licenseKeySettingsModel?: LicenseKeySettingsModel;
   localizationSettingsModel?: LocalizationSettingsModel;
   mvSettingsModel?: MVSettingsModel;
   cacheSettingsModel?: CacheSettingsModel;
   emailSettingsModel?: EmailSettingsModel;
   performanceSettingsModel?: PerformanceSettingsModel;
   securityEnabled?: boolean;
}
