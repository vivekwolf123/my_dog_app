package com.client.vivekwolf.android.core_base

enum class ErrorType(val code: Int) {
    MALFORMED_REQUEST(400),
    SERVER_ERROR(500),
    NO_INTERNET(-1),
    UNKNOWN_ERROR(-2),
    DOG_INFO_LIST_ERROR(-3),
    DOG_ACTIVITY_ERROR(-4),
    DOG_FACTS_ERROR(-5);

    companion object {
        private val types = entries.associateBy { it.code }

        fun handleErrorCode(value: Int): ErrorType {
            types[value]?.let {
                return it
            }
            return UNKNOWN_ERROR
        }
    }
}
