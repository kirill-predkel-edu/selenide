package config.context

import config.context.dynamic.DynamicContextHolder

internal fun dynamicContext() = DynamicContextHolder.getContext()
internal fun sessionContext() = dynamicContext().getSessionContext()
internal fun stubContext() = dynamicContext().getStubContext()
internal fun getAuthUser(): String = sessionContext().getAuthUserCookie()