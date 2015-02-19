package com.sivalabs.sgdemo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by skatam on 18-12-2014.
 */
@Component
@ConfigurationProperties(prefix = 'app')
class AppConfig {

    String name
    String description
}
