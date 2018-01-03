/*
时间：2017/12/15   17:15
作者：Fangzq
鼠标移动有星星跟随的效果  例子参照星空连线 
18：12第一次尝试自己写  怀挺！
2017/12/16 第二次调试失败 好崩溃！
*/

(function() {

    var width, height, largeHeader, canvas, ctx, points, target, animateHeader = true;

    initHeader();
    initAnimation();
    addListener();


    function initHeader() {

        width = window.innerWidth; //  宽度
        height = window.innerHeight; //高度
        // alert('宽度:1880'+width+'  高度: 415'+height);
        target = { x: width / 2, y: height / 2 };  //最开始点在页面的中央
        // alert('target:'+target);

        largeHeader = document.getElementById('largeHeader');

        largeHeader.style.height = height + 'px';

        // alert('largerHeader.style.height:415px'+largeHeader.style.height);

        canvas = document.getElementById('canvas');
        canvas.width = width;
        canvas.height = height;
        ctx = canvas.getContext('2d'); //getcontext返回画图的环境，指定二维画图
        points = []; //点

        //在画布上画点
        for (var x = 0; x < width; x = x + width / 30) {

            for (var y = 0; y < height; y = y + height / 30) {

                var px = x + Math.random() * width / 30;
                var py = y + Math.random() * height / 30;

                var p = { x: px, originX: px, y: py, originY: py };

                // if ((x <= 1) && (y >= 2)) {

                //     alert('px:' + px + '  py:' + py + '    x:' + p.x + '    originX:' + p.originX + '    y:' + p.y + '    originY:' + p.originY);
                // }
                points.push(p);
            }
        }



        //每个点找到最近的五个点
        for (var i = 0; i < points.length; i++) {
            var closest = [];
            var p1 = points[i];
            for (var j = 0; j < points.length; j++) {
                var p2 = points[j];
                if (!(p1 == p2)) {
                    var placed = false;
                    for (var k = 0; k < 3; k++) {
                        if (!placed) {
                            if (closest[k] == undefined) {
                                closest[k] = p2;
                                placed = true;

                            }
                        }

                    }
                    for (var k = 0; k < 3; k++) {
                        if (!placed) {
                            if (getDistance(p1, p2) < getDistance(p1, closest[k])) {
                                closest[k] = p2;
                                placed = true;
                            }
                        }
                    }
                }

            }

            p1.closest = closest;
        }


        //每个点画圆点
        for (var i in points) {
            var c = new Circle(2,5,points[i], 'rgba(255,255,255,0.3)');
            points[i].circle = c;
        }

    }


    function addListener() {
        // alert("addListener");
        /*
        addEventListener(arg0,arg1)
        arg0--事件的类型
        arg1--事件处理的函数
        */

        //判断条件：不是移动端
            window.addEventListener('mousemove', mouseMove);
        


        window.addEventListener('scroll', scrollCheck);
        window.addEventListener('resize', resize);

    }


    /*
        mouseMove()
        功能：鼠标移动的事件
        clientX:是鼠标相对于浏览器可是区域的X坐标，可视区域不包括工具栏和滚动条
        pageX:当页面内容小于屏幕分辨率，即页面不能左右滑动时,pageX和clientX的值是一样的；
            只有页面内容大于屏幕分辨率时，pageX和clientX的值就不一致了.这时候的pageX=时间距离浏览器左边距x轴的距离

        document.body.scrollLeft置或获取位于对象左边界和窗口中目前可见内容的最左端之间的距离
    */
    function mouseMove(e) {
        var posx = posy = 0;
        if (e.pageX || e.pageY) { //如果e.pageX或者e.pageY不为0时候执行下面的语句
            posx = e.pageX;
            posy = e.pageY;

        } /*
        else if (e.clientX || e.clientY) {
            posx = e.clientX + docuemnt.body.scrollLeft + docuemnt.docuemntElement.scrollLeft;
            posy = e.clientY + docuemnt.body.scrollTop + docuemnt.docuemntElement.scrollTop;
        }*/
        target.x = posx;
        target.y = posy;
        // alert('x:'+target.x+'   y:'+target.y);
    }

    function scrollCheck() {
        if (docuemnt.body.scrollTop > height) {
            animateHeader = false;
        } else {
            animateHeader = true;
        }
    }



    /*
    resize()
    功能：当页面大小发生变化时，要重新调整画布的大小
    */
    function resize() {
        width = window.innerWidth;
        height = window.innerHeight;
        largeHeader.style.height = height + 'px';
        canvas.width = width;
        canvas.height = height;
    }




    /*
     */
    function initAnimation() {
        animate();
        for (var i in points) {
            shiftPoint(points[i]);
        }
    }


   function  shiftPoint(p){
    /*
     TweenLite.to(target,duration,vars,alpha)
     target--目标对象
     duration--动画持续的时间
     vars--对象，通过属性值，来存各种属性参数用于缓动。
            x:改变movieclip的值，把这个值设成你希望的movieclip结束的位置
            ease:function--缓动函数。Circ.easeInOut
            onComplete--function缓动结束时执行的函数.

    */
    TweenLite.to(p,1+1*Math.random(),{x:p.originX-50+Math.random()*100,y:p.originY-50+Math.random()*100,ease:Circ.easeInOut,
        onComplete:function(){
            shiftPoint(p);
        }});
   }



    /*
    animate()
    功能：设置动画，线条的透明度和圆点的透明度
    解析：target的值是从mouseMove()函数中获得，实际代表的是鼠标点的坐标信息.
    target与屏幕上点的每个点都计算了距离，根据距离的大小分别设置点的透明度以及相应线条的透明度
    调用函数：drawLines()  circle.draw()
    */
    function animate() {
        if (animateHeader) {
            ctx.clearRect(0, 0, width, height); //clearRect清除canvas以(0,0)为左上角
            for (var i in points) {
                if (Math.abs(getDistance(target, points[i])) < 4000) {
                  
                    points[i].circle.active = 0.6; //设置圆点的透明度

                } else if (Math.abs(getDistance(target, points[i])) < 20000) {
                   
                    points[i].circle.active = 0.3; //设置圆点的透明度
                } else if (Math.abs(getDistance(target, points[i])) < 40000) {
                  
                    points[i].circle.active = 0.1; //设置圆点的透明度
                } else {
                   
                    points[i].circle.active = 0; //设置圆点的透明度

                }
                points[i].circle.draw();
                // alert("animate!");
            }
        }
        requestAnimationFrame(animate);
    }

 

    /*
    Circle()
    功能：画星星
    pos:点的坐标信息
    smallRadius:小圆半径
    bigRadius:大圆半径
    参考资料：http://www.php.cn/html5-tutorial-353336.html
    */
       function Circle(smallRadius, bigRadius, pos, color) {
        var _this = this;
        (function() {
            _this.pos = pos || null;
            _this.smallRadius = smallRadius || null;
            _this.color = color || null;
            _this.bigRadius = bigRadius || null;


        })();
        this.draw = function() {
            if (!_this.active) {
                return;
            }
            ctx.beginPath(); //开始一条路径
            for (var i = 0; i < 5; i++) {
                ctx.lineTo(Math.cos((18 + 72 * i) / 180 * Math.PI) * _this.bigRadius + _this.pos.x, -Math.sin((18 + 72 * i) / 180 * Math.PI) * _this.bigRadius + _this.pos.y);
                ctx.lineTo(Math.cos((54 + 72 * i) / 180 * Math.PI) * _this.smallRadius + _this.pos.x, -Math.sin((54 + 72 * i) / 180 * Math.PI) * _this.smallRadius + _this.pos.y);
            }
            ctx.closePath();
            ctx.fillStyle = 'rgba(156,217,249,' + _this.active + ')';
            ctx.fill();
        };
    }

    /*
    getDistance()
    功能：获得两点间的距离
    */
    function getDistance(p1, p2) {
        return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)
    }



})();