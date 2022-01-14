package config.context

import config.context.dynamic.DynamicContextHolder

internal fun dynamicContext() = DynamicContextHolder.getContext()
internal fun sessionContext() = dynamicContext().sessionContext
internal fun stubContext() = dynamicContext().stubContext
internal fun getAuthUser(): String = sessionContext().authUser