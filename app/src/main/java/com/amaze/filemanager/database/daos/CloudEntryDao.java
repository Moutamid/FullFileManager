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

import static com.amaze.filemanager.database.ExplorerDatabase.COLUMN_CLOUD_SERVICE;
import static com.amaze.filemanager.database.ExplorerDatabase.TABLE_CLOUD_PERSIST;

import java.util.List;

import com.amaze.filemanager.database.models.explorer.CloudEntry;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * {@link Dao} interface definition for {@link CloudEntry}. Concrete class is generated by Room
 * during build.
 *
 * @see Dao
 * @see CloudEntry
 * @see com.amaze.filemanager.database.ExplorerDatabase
 */
@Dao
public interface CloudEntryDao {

  @Insert
  Completable insert(CloudEntry entry);

  @Query(
      "SELECT * FROM " + TABLE_CLOUD_PERSIST + " WHERE " + COLUMN_CLOUD_SERVICE + " = :serviceType")
  Single<CloudEntry> findByServiceType(int serviceType);

  @Query("SELECT * FROM " + TABLE_CLOUD_PERSIST)
  Single<List<CloudEntry>> list();

  @Update
  Completable update(CloudEntry entry);

  @Delete
  Completable delete(CloudEntry entry);
}
