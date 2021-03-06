/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 * The ontology is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ontology is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.github.ontio.controller;

import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.CurrentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouq
 * @version 1.0
 * @date 2018/2/27
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/v1/explorer")
public class CurrentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Autowired
    private CurrentServiceImpl currentService;


    /**
     * query current summary information
     *
     * @return
     */
    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    @ResponseBody
    public Result querySummaryInfo() {

        logger.info("########{}.{} begin...", CLASS_NAME, this.currentMethod());

        Result rs = currentService.querySummaryInfo();
        return rs;
    }



    private String currentMethod() {
        return new Exception("").getStackTrace()[1].getMethodName();
    }

}
