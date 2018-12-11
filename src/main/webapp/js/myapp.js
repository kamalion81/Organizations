'use strict';

var app = angular.module('myapp', ['ngResource', 'ui.bootstrap']);


app.factory('Organization', ['$resource', function ($resource) {
    return $resource('/organizations/:id', {id: '@id'}, {
        update: {method: 'PUT'}
    });
}]);

app.controller('OrgController', function ($scope, Organization) {


    $scope.current = new Organization();


    var list = function () {
        $scope.organizations = Organization.query();
    };


    $scope.add = function (notValid) {

        if (!notValid) {
            var org = new Organization();
            org.name = $scope.current.name;
            org.info = $scope.current.info;
            org.address = $scope.current.address;
            org.telephone = $scope.current.telephone;
            org.countEmployees = $scope.current.countEmployees;
            org.$save(function () {
                list();
            });
        }

    };

    $scope.delete = function (id) {

        Organization.delete({id: id}, function () {
            $scope.current = new Organization();
            list();

        });
    };

    $scope.show = function (id) {
        $scope.current = Organization.get({id: id});

    };

    $scope.update = function (notValid) {

        if (!notValid) {
            Organization.update($scope.current, function () {
                list();
            });
        }

    }

    list();
});



