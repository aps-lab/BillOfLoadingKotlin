package de.adorsys.billofloadinglibrary

import org.joda.time.LocalDateTime

data class BillOfLoadingEntry(
    val uuid: String
) {
    var usedAt: LocalDateTime? = null

    fun isUsed() = usedAt != null

    override fun equals(other: Any?): Boolean {
        if (other is BillOfLoadingEntry) {
            return this.uuid == other.uuid
        }
        return false
    }

    override fun toString(): String =
        "\nBillOfLoadingEntry\n" +
                "id:" + uuid + ",\n" +
                "usedAt:" +
                if (usedAt != null) {
                    usedAt?.toString(
                        "yyyy-MM-dd HH:mm:ss.SSS"
                    )
                } else "unused" + "\n"

    override fun hashCode(): Int {
        var result = uuid.hashCode()
        result = 31 * result + (usedAt?.hashCode() ?: 0)
        return result
    }

}

