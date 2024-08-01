package core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class RepeatingTask (
    private val functionA:()->Unit,
    private val functionB:()->Unit,
    private val delay: Long
){
    private var job: Job? = null

    fun start() {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                functionA()
                delay(delay)
                functionB()
            }
        }
    }

    fun stop() {
        job?.cancel()
    }
}