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

package com.amaze.filemanager.utils;

import android.app.Service;
import android.os.Binder;

/**
 * @author Emmanuel on 28/11/2017, at 19:04.
 */
public class ObtainableServiceBinder<T extends Service> extends Binder {

  private final T service;

  public ObtainableServiceBinder(T service) {
    this.service = service;
  }

  public T getService() {
    return service;
  }
}
