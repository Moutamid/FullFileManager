/*
 * Copyright (c) 2022 FullDive
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.ui.theme;

import com.amaze.filemanager.ui.fragments.preferencefragments.PreferencesConstants;

import android.content.SharedPreferences;

/** Saves and restores the AppTheme */
public class AppThemeManager {
  private SharedPreferences preferences;
  private AppTheme appTheme;
  private final boolean isNightMode;

  public AppThemeManager(SharedPreferences preferences, boolean isNightMode) {
    this.preferences = preferences;
    this.isNightMode = isNightMode;
    String themeId = preferences.getString(PreferencesConstants.FRAGMENT_THEME, "4");
    appTheme =
        AppTheme.getTheme(isNightMode, Integer.parseInt(themeId)).getSimpleTheme(isNightMode);
  }

  /**
   * @return The current Application theme
   */
  public AppTheme getAppTheme() {
    return appTheme.getSimpleTheme(isNightMode);
  }

  /**
   * Change the current theme of the application. The change is saved.
   *
   * @param appTheme The new theme
   * @return The theme manager.
   */
  public AppThemeManager setAppTheme(AppTheme appTheme) {
    this.appTheme = appTheme;
    return this;
  }
}
