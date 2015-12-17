
var creative = {};

/**
 * Window onload handler.
 */
function preInit() {
  setupDom();

  if (Enabler.isInitialized()) {
    init();
  } else {
    Enabler.addEventListener(
      studio.events.StudioEvent.INIT,
      init
    );
  }
}

/**
 * Select ad elements with zepto selectors to setup dom
 */
function setupDom() {
  creative.dom = {};
  creative.dom.mainContainer = document.getElementById('main-container');
  creative.dom.exit = document.getElementById('exit');
  //Animation Elements

  creative.dom.copy1 = $('#copy1');
  creative.dom.copy2 = $('#copy2');
  creative.dom.copy3 = $('#copy3');
  creative.dom.copy4 = $('#copy4');

  creative.dom.logo = $('#logo');
  creative.dom.cta = $('#cta');

  creative.dom.startNowButtonShimmer = $('.icon-effect');

}

/**
 * Ad initialisation.
 */
function init() {

  addListeners();

  // Polite loading
  if (Enabler.isVisible()) {
    show();
  }
  else {
    Enabler.addEventListener(studio.events.StudioEvent.VISIBLE, show);
  }
}

/**
 * Adds appropriate listeners at initialization time
 */
function addListeners() {
  creative.dom.exit.addEventListener('click', exitClickHandler);
}

/**
 *  Shows the ad.
 */
function show() {
  creative.dom.exit.style.display = "block";
    //run the animations

  runAnimationLoop();
}


function runAnimationLoop(){

  creative.MainTimeline = new TimelineLite({
     onComplete:repeatMainTimeline
  });

  creative.MainTimeline
    .addLabel('frame-1')
    .to(creative.dom.copy1, 0.75, {left:-320,  ease:Circ.easeInOut, delay:2}, 'frame-1')
    .to(creative.dom.copy2, 0.75, {left:420, autoAlpha:0,  ease:Circ.easeInOut, delay:2}, 'frame-1')

    .to(creative.dom.copy3, 0.75, {autoAlpha:1, delay:2.5}, 'frame-1')
	.to(creative.dom.copy4, 0.75, {autoAlpha:1, delay:2.5}, 'frame-1')

    .addLabel('frame-2')

.to(creative.dom.cta, 0.5, {scale:1, ease:Circ.easeOut, delay:0.5}, 'frame-2')

.addLabel('shimmer')
.set(creative.dom.startNowButtonShimmer, {className: "+=shimmer"},'shimmer')
.to(creative.dom.startNowButtonShimmer,0.6, {autoAlpha:0,delay:0.5},'shimmer')

creative.playedOnce = false;
function repeatMainTimeline(){
  if (creative.playedOnce == false) {
    creative.playedOnce = true;
    setTimeout(function(){
      creative.MainTimeline.restart();
    },3000)
  } else {
    stopCursorBlink()
  }
}

}


// ---------------------------------------------------------------------------------
// MAIN
// ---------------------------------------------------------------------------------

function exitClickHandler() {
  Enabler.exit('BackgroundExit');
}

/**
 *  Main onload handler
 */
window.addEventListener('load', preInit);
