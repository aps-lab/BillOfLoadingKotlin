package de.adorsys.billofloading

import org.joda.time.LocalDate
import org.junit.Assert
import org.junit.Test

class BillOfLoadingInitializerTest {

    @Test
    fun testInitBillOfLoadingSuccessfull() {
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        print(billOfLoading.entries.toString())
        Assert.assertTrue(billOfLoading.entries.size == 100)
    }

    @Test
    fun testGetNextEmptyBolSuccessfull() {
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        print(billOfLoading.entries.toString())

        billOfLoading.getNextUnusedEntry()
        Assert.assertTrue(billOfLoading.getNextUnusedEntry() == billOfLoading.entries.first())
    }

    @Test
    fun testGetNextEmptyBolIfFirstBolIsUsed() {
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        print(billOfLoading.entries.toString())
        billOfLoading.entries[0].usedAt = LocalDate.now()

        Assert.assertTrue(billOfLoading.getNextUnusedEntry() == billOfLoading.entries[1])
    }

    @Test
    fun testGetNextUsedBolSuccesfull() {
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        print(billOfLoading.entries.toString())
        billOfLoading.entries[0].usedAt = LocalDate.now()

        Assert.assertTrue(billOfLoading.getNextusedEntry() == billOfLoading.entries[0])
    }

}