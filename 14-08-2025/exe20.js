var Generic = /** @class */ (function () {
    function Generic() {
    }
    Generic.prototype.pair = function (first, second) {
        return [first, second];
    };
    return Generic;
}());
var generic = new Generic();
console.log(generic.pair("age", 23));
