'use strict';

/**
 * @ngdoc overview
 * @name hlApp
 * @description
 * # hlApp
 *
 * Main module of the application.
 */
angular
  .module('hlApp', [
    'ui.bootstrap','ngRoute','ngGrid'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/articles', {
        templateUrl: 'views/articles.html',
        controller: 'ArticlesCtrl'
      })
      .when('/gallery', {
        templateUrl: 'views/gallery.html',
        controller: 'GalleryCtrl'
      })
      .when('/subscribers', {
        templateUrl: 'views/subscribers.html',
        controller: 'SubscribersCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
