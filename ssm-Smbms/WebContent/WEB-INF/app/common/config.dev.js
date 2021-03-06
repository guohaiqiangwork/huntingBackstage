﻿define({
    app: {
        name: '',
        client: '',
        version: window.NEPTUNE.version
    },
    httpPackage: {
        method: 'POST',
        dataType: 'json',
        url: '',
        contentType: 'application/json; charset=UTF-8', // application/x-www-form-urlencoded; charset=UTF-8
        useDefaultXhrHeader: false,
        header: {},
        data: {},
        timeout:30000
    },
    //请求路径
    backend: {
         ip: 'http://huahongshunda.applinzi.com/'//佳龙本地ip
       // ip: 'http://192.168.0.105:8081/hunting/'//佳龙本地ip

    },
    auth:{
        isLogin:false,
        isSave:true
    },
    //分页
    pagination: {
        pageSize: 20,
        previousText: '上一页',
        nextText: '下一页',
        firstText: '首页',
        lastText: '尾页'
    },
    //各接口参数配置
    requestMethods:{
        login:'login',
        getUser:'getUser'
    },
    method:''
});