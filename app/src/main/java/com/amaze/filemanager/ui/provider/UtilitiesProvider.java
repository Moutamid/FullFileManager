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

package com.amaze.filemanager.ui.provider;

import com.amaze.filemanager.ui.colors.ColorPreferenceHelper;
import com.amaze.filemanager.ui.theme.AppTheme;
import com.amaze.filemanager.ui.theme.AppThemeManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import androidx.preference.PreferenceManager;

/** Created by piotaixr on 16/01/17. */
public class UtilitiesProvider {
  private ColorPreferenceHelper colorPreference;
  private AppThemeManager appThemeManager;

  public UtilitiesProvider(Context context) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    colorPreference = new ColorPreferenceHelper();
    colorPreference.getCurrentUserColorPreferences(context, sharedPreferences);
    appThemeManager =
        new AppThemeManager(
            sharedPreferences,
            (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES);
  }

  public ColorPreferenceHelper getColorPreference() {
    return colorPreference;
  }

  public AppTheme getAppTheme() {
    return appThemeManager.getAppTheme();
  }

  public AppThemeManager getThemeManager() {
    return appThemeManager;
  }
}
