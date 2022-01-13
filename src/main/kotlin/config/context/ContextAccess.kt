package config.context

import config.context.dynamic.DynamicContextHolder

internal fun dynamicContext() = DynamicContextHolder.getContext()
internal fun sessionContext() = dynamicContext().getSessionContext()
internal fun getAuthUser(): String = dynamicContext().getAuthUserToken()