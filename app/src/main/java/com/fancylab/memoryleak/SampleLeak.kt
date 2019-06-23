package com.fancylab.memoryleak

import android.content.Context

class SampleLeak private constructor() {
    companion object {
        private var INSTANCE: SampleLeak? = null
        private var CONTEXT: Context? = null

        fun instance(context: Context): SampleLeak =
            INSTANCE ?: createInstance().also {
                INSTANCE = it
                CONTEXT = context
            }

        private fun createInstance() = SampleLeak()
    }
}