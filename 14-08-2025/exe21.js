var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var box1 = new Box("Murali");
var box2 = new Box(23);
console.log(box1.getValue());
console.log(box2.getValue());
