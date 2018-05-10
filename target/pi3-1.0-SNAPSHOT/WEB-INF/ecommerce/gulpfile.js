var gulp = require('gulp');
var concat = require('gulp-concat');
var browserSync = require('browser-sync').create();

var scripts = [
    './node_modules/jquery/dist/jquery.js',
    './node_modules/angular/angular.js',
    './node_modules/angular-cookies/angular-cookies.js',
    './node_modules/angular-sanitize/angular-sanitize.js',
    './node_modules/materialize-css/dist/js/materialize.js',
    './src/js/*.js'
];

var styles = [
    './node_modules/materialize-css/dist/css/materialize.css',
    './src/css/**/*.css'
];

gulp.task('scripts', function () {
    return gulp.src(scripts)
        .pipe(concat('all.js'))
        .pipe(gulp.dest('./dist/js/'))
});

gulp.task('styles', function () {
    return gulp.src(styles)
        .pipe(concat('all.css'))
        .pipe(gulp.dest('./dist/css/'))
});

gulp.task('js-watch', function (done) {
    gulp.start('scripts');
    browserSync.reload();
    done();
});

gulp.task('css-watch', function (done) {
    gulp.start('styles');
    browserSync.reload();
    done();
});

gulp.task('jsons', function () {
    return gulp.src('./src/json/*.json')
        .pipe(gulp.dest('./dist/json/'))
});

gulp.task('serve',  function() {

    browserSync.init({
        server: "./dist"
    });

    gulp.watch("./src/js/*.js", ['js-watch']);
    gulp.watch("./src/css/*.css", ['css-watch']);
});

gulp.task('dev', ['scripts', 'styles', 'jsons', 'serve']);