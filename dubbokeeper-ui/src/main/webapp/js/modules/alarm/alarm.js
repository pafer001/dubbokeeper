var alarm = angular.module("alarm", ['ngAnimate', 'ngRoute', 'serviceProvider', 'queryFilter', 'breadCrumb']);

alarm.config(function ($routeProvider) {
    $routeProvider.when("/alarm", {
        templateUrl: "templates/alarm/index.html",
        controller: "/alarm/index"
    }).when("/alarm/:application/InterfaceServiceMethod", {
        templateUrl: "templates/alarm/strategy.html",
        controller: "/alarm/application/strategy"
    }).when("/alarm/strategy/edit/:application/:serviceInterface/:method", {
        templateUrl: "templates/alarm/edit-strategy.html",
        controller: "/alarm/strategy/edit"
    });
});

alarm.controller("/alarm/strategy/edit", function ($scope, $httpWrapper, $queryFilter, $breadcrumb, $menu, $routeParams) {
    $menu.switchMenu("alarm");
    $scope.applications = [];
    $scope.isEmpty = false;
    $breadcrumb.pushCrumb("应用列表", "查看应用列表", "admin/apps");
    var requestUrl = "alarm/" + $routeParams.application+"/"+$routeParams.serviceInterface+ "/"+$routeParams.method + "/strategy.htm";
    $scope.application = $routeParams.application;

    $httpWrapper.post({
        url: requestUrl,
        success: function (data) {
            $scope.applications = data;
            if (!data || data.length < 0) {
                $scope.isEmpty = true;
            }
            $scope.originData = data;
        }
    });
    $scope.query = {};
    $scope.filter = function () {
        var filterResult = [];
        if ($scope.isEmpty) {
            return;
        }
        $scope.applications = $queryFilter($scope.originData, $scope.query);
    }
});


alarm.controller("/alarm/application/strategy", function ($scope, $httpWrapper, $queryFilter, $breadcrumb, $menu, $routeParams) {
    $menu.switchMenu("alarm");
    $scope.applications = [];
    $scope.isEmpty = false;
    $breadcrumb.pushCrumb("应用列表", "查看应用列表", "admin/apps");
    var requestUrl = "alarm/" + $routeParams.application + "/strategy.htm";
    $scope.application = $routeParams.application;

    $httpWrapper.post({
        url: requestUrl,
        success: function (data) {
            $scope.applications = data;
            if (!data || data.length < 0) {
                $scope.isEmpty = true;
            }
            $scope.originData = data;
        }
    });
    $scope.query = {};
    $scope.filter = function () {
        var filterResult = [];
        if ($scope.isEmpty) {
            return;
        }
        $scope.applications = $queryFilter($scope.originData, $scope.query);
    }
});

alarm.controller("/alarm/application/strategy", function ($scope, $httpWrapper, $queryFilter, $breadcrumb, $menu, $routeParams) {
    $menu.switchMenu("alarm");
    $scope.applications = [];
    $scope.isEmpty = false;
    $breadcrumb.pushCrumb("应用列表", "查看应用列表", "admin/apps");
    var requestUrl = "alarm/" + $routeParams.application + "/strategy.htm";
    $scope.application = $routeParams.application;

    $httpWrapper.post({
        url: requestUrl,
        success: function (data) {
            $scope.applications = data;
            if (!data || data.length < 0) {
                $scope.isEmpty = true;
            }
            $scope.originData = data;
        }
    });
    $scope.query = {};
    $scope.filter = function () {
        var filterResult = [];
        if ($scope.isEmpty) {
            return;
        }
        $scope.applications = $queryFilter($scope.originData, $scope.query);
    }
});

alarm.controller("/alarm/index", function ($scope, $httpWrapper, $queryFilter, $breadcrumb, $menu) {
    $menu.switchMenu("alarm");
    $scope.applications = [];
    $scope.isEmpty = false;
    $breadcrumb.pushCrumb("应用列表", "查看应用列表", "admin/apps");
    $httpWrapper.post({
        url: "alarm/app/list.htm",
        success: function (data) {
            $scope.applications = data;
            if (!data || data.length < 0) {
                $scope.isEmpty = true;
            }
            $scope.originData = data;
        }
    });
    $scope.query = {};
    $scope.typeOptions = [{
        val: 1,
        text: "P"
    }, {
        val: 2,
        text: "C"
    }, {
        val: 3,
        text: "P.AND.C"
    }];
    $scope.filter = function () {
        var filterResult = [];
        if ($scope.isEmpty) {
            return;
        }
        $scope.applications = $queryFilter($scope.originData, $scope.query);
    }
});


