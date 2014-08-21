/**
 * Created by j2 on 20-08-14.
 */
(function(window, angular, undefined) {
    "use strict";

    var app = angular.module('Map', ['MapServer', 'ngRoute']);

    app.config(function ($routeProvider) {

        $routeProvider
            .when('/', {
                controller: 'MapController'
            })
            .otherwise({ redirectTo: '/' });
    });

    app.controller('MapController', ['$scope', 'ServerParams', 'ServerFuncs', function($scope, ServerParams, ServerFuncs) {
        $scope.reds = ['A1', 'A2', 'A3', 'C1', 'C4'];
        $scope.oranges = ['B1', 'B3', 'B4', 'D1', 'D2', 'D3', 'D4', 'C5'];
        $scope.blues = ['A4', 'C3', 'D7', 'D6PB', 'E1'];
        $scope.greens = ['C2A', 'C2B', 'C6', 'C7'];
        $scope.lilas = ['D5', 'D6'];
        $scope.blacks = ['B2', 'B5', 'C6PA', 'D6PA', 'E2'];
        $scope.events = [];

        $scope.$on('after-fetch-events', function (event, data) {
           $scope.$apply(function() {
               $scope.events = data.events;
           });
        });

        $scope.fetchEvents = function() {
            ServerFuncs.fetchEvents();
        };

        $scope.contains = function(value, arr) {
            return $.inArray(value, arr) !== -1;
        };

        $scope.$watch( 'events', function(newValue, oldValue) {
        });

        $scope.fetchEvents();
    }]);


    window.mapApp = app;

})(this, angular);
