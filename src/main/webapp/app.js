(function () {
    'use strict';

    angular.module('aulaFerias', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                 .when('/', {
                    controller: 'UsuarioCtrl',
                    templateUrl: 'partials/usuario/usuario.html'
                })
                .otherwise('/');
        }]);

}());