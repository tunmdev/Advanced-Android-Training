package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.ContactInfo
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.entity.SchoolWithStudents
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ContactInfoDao {
    @Insert
    fun insertContactInfo(contactInfo: ContactInfo): Completable

    @Query("SELECT * FROM contact_info WHERE contact_info_id = :contactInfoId")
    fun getContactInfoById(contactInfoId: Int): Single<ContactInfo?>
}