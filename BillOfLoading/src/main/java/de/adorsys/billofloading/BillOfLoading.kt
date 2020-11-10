package de.adorsys.billofloading

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.LocalDate
import org.joda.time.tz.UTCProvider
import java.util.*


data class BillOfLoading(
    val receiverId: String,
    val creationDate: LocalDate,
    val entries: List<BillOfLoadingEntry>
) {

    fun getNextUnusedEntry(): BillOfLoadingEntry =
        entries.first { billOfLoadingEntry -> billOfLoadingEntry.usedAt == null }


    fun getNextusedEntry(): BillOfLoadingEntry =
        entries.first { billOfLoadingEntry -> billOfLoadingEntry.isUsed() }


    companion object {
        fun createBillOfLoadingList(size: Int, receiverId: String): BillOfLoading {
            //make sure that DateTimeZone is set
            DateTimeZone.setProvider(UTCProvider())

            val mutableList = mutableListOf<BillOfLoadingEntry>()
            for (i in 1..size) {
                mutableList.add(BillOfLoadingEntry(UUID.randomUUID()))
            }
            return BillOfLoading(receiverId, DateTime.now().toLocalDate(), mutableList.toList())
        }
    }

}


