package de.adorsys.billofloadinglibrary

import org.joda.time.LocalDateTime
import org.junit.Assert
import org.junit.Test
import kotlin.jvm.Throws

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
        billOfLoading.entries[0].usedAt =  LocalDateTime.now()

        Assert.assertTrue(billOfLoading.getNextUnusedEntry() == billOfLoading.entries[1])
    }

    @Test
    fun testGetNextUsedBolSuccesfull() {
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        print(billOfLoading.entries.toString())
        billOfLoading.entries[0].usedAt =  LocalDateTime.now()
        Assert.assertTrue(billOfLoading.getNextusedEntry() == billOfLoading.entries[0])
    }

    @Test
    fun testSetBolEntryUsed(){
        val billOfLoading = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        billOfLoading.setBolEntryUsed(billOfLoading.entries.first().uuid)
        Assert.assertTrue(billOfLoading.getNextUnusedEntry() == billOfLoading.entries[1])
    }

}