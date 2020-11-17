package de.adorsys.billofloadinglibrary

import org.joda.time.DateTimeZone
import org.joda.time.LocalDateTime
import org.joda.time.tz.UTCProvider
import java.util.*


data class BillOfLoading(
    val receiverId: String,
    val creationDate: LocalDateTime,
    val entries: List<BillOfLoadingEntry>
) {

    init {
        DateTimeZone.setProvider(UTCProvider())
    }

    fun getNextUnusedEntry(): BillOfLoadingEntry =
        entries.first { billOfLoadingEntry -> billOfLoadingEntry.usedAt == null }


    fun getNextusedEntry(): BillOfLoadingEntry =
        entries.first { billOfLoadingEntry -> billOfLoadingEntry.isUsed() }

    fun setBolEntryUsed(uuid: String) {
        entries.first { billOfLoadingEntry -> billOfLoadingEntry.uuid == uuid }.usedAt =
            LocalDateTime.now()
    }

    companion object {
        fun createBillOfLoadingList(size: Int, receiverId: String): BillOfLoading {
            //make sure that DateTimeZone is set
            DateTimeZone.setProvider(UTCProvider())

            val mutableList = mutableListOf<BillOfLoadingEntry>()
            for (i in 1..size) {
                mutableList.add(BillOfLoadingEntry(UUID.randomUUID().toString()))
            }
            return BillOfLoading(receiverId, LocalDateTime.now(), mutableList.toList())
        }
    }

}


