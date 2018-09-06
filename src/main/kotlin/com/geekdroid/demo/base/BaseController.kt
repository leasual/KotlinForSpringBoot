package com.geekdroid.demo.base

import org.slf4j.LoggerFactory

abstract class BaseController {

    protected val logger = LoggerFactory.getLogger(this.javaClass)
}