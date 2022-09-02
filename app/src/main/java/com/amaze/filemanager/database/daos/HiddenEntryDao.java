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

package com.amaze.filemanager.database.daos;

import static com.amaze.filemanager.database.UtilitiesDatabase.COLUMN_PATH;
import static com.amaze.filemanager.database.UtilitiesDatabase.TABLE_HIDDEN;

import java.util.List;

import com.amaze.filemanager.database.models.utilities.Hidden;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * {@link Dao} interface definition for {@link Hidden}. Concrete class is generated by Room during
 * build.
 *
 * @see Dao
 * @see Hidden
 * @see com.amaze.filemanager.database.UtilitiesDatabase
 */
@Dao
public interface HiddenEntryDao {

  @Insert
  Completable insert(Hidden instance);

  @Update
  Completable update(Hidden instance);

  @Query("SELECT " + COLUMN_PATH + " FROM " + TABLE_HIDDEN)
  Single<List<String>> listPaths();

  @Query("DELETE FROM " + TABLE_HIDDEN + " WHERE " + COLUMN_PATH + " = :path")
  Completable deleteByPath(String path);
}
