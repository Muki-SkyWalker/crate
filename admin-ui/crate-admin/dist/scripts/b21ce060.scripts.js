"use strict";var crateAdminApp=angular.module("crateAdminApp",["stats","common","overview","console","docs"]);crateAdminApp.config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/empty_overview.html",controller:"OverviewController"}).when("/console",{templateUrl:"views/console.html",controller:"ConsoleController"}).when("/docs",{templateUrl:"views/docs.html",controller:"DocsController"}).otherwise({redirectTo:"/"})}]),crateAdminApp.run(["ClusterState",function(){}]),angular.module("stats",[]).factory("ClusterState",["$http","$timeout","$location","$log","$rootScope",function(a,b,c){function d(a){var b=0,c=[0,0,0];for(var d in a){b++;for(var e=0;3>e;e++)c[e]=c[e]+a[d].os.load_average[e]}for(var e;3>e;e++)c[e]=c[e]/b;return c}var e=c.search().prefix||"",f={green:"label-success",yellow:"label-warning",red:"label-important"},g={name:"",status:"",color:"",load:[0,0,0]},h=function(){a({method:"GET",url:e+"/_cluster/health"}).success(function(a){g.name=a.cluster_name,g.status=a.status,g.color=f[a.status]}).error(function(){}),b(h,5e3)},i=function(){a({method:"GET",url:e+"/_nodes/stats?all=true"}).success(function(a){g.load=d(a.nodes)}).error(function(){}),b(i,5e3)};return h(),i(),{data:g}}]),angular.module("common",["stats"]).controller("StatusBarController",["$scope","$log","ClusterState",function(a,b,c){a.$watch(function(){return c.data},function(b){a.cluster_state=b.status,a.cluster_name=b.name,a.cluster_color=b.color,a.load1=b.load[0].toFixed(2),a.load5=b.load[1].toFixed(2),a.load15=b.load[2].toFixed(2)},!0)}]).controller("NavigationController",["$scope","$location",function(a,b){a.isActive=function(a){return a===b.path()}}]),angular.module("overview",["stats"]).controller("OverviewController",["$scope","$log","ClusterState",function(a,b,c){a.$watch(function(){return c.data},function(b){a.cluster_state=b.status,a.cluster_color=b.color,a.replicated_data="90%",a.available_data="100%",a.records_total=235e3,a.records_underreplicated=2e4,a.records_unavailable=0},!0)}]),angular.module("console",[]).controller("ConsoleController",["$scope","$http","$location",function(a,b,c){a.statement="",a.result={rows:[]},$("iframe").hide(),a.resultHeaders=[],a.error={},a.error.hide=!0,a.execute=function(){var d=c.search().prefix||"";b.post(d+"/_sql",{stmt:a.statement}).success(function(b){a.error.hide=!0,a.resultHeaders=[];for(var c in b.cols)a.resultHeaders.push(b.cols[c]);a.result=b}).error(function(b){a.error.hide=!1,a.error.message=b.error})}}]),angular.module("docs",[]).controller("DocsController",["$scope","$location",function(a,b){var c=b.search().prefix||"";a.url=c+"/_plugin/docs"}]);