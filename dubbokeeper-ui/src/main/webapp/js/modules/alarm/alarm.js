var alarm = angular.module("alarm", ['ngRoute', 'fullScreen', 'lineChart', 'breadCrumb', 'isteven-multi-select']);

alarm.config(function ($routeProvider) {
    $routeProvider.when("/alarm", {
        templateUrl: "templates/alarm/index.html",
        controller: "index"
    });
});

