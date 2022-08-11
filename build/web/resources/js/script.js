var audioPlayer = document.getElementById('audio-player');
var btnPlay = document.getElementById('btnPlay');
var btnPause = document.getElementById('btnPause');
var progressBar = document.querySelector('.player-control-track-progress-2');
var currentTime = document.getElementById('current-time');
var fullTime = document.getElementById('full-time');
var interval = null;

btnPause.addEventListener('click', (e) => {

    clearInterval(interval);
    e.preventDefault();
    audioPlayer.pause();
    btnPlay.style.display = "inline";
    btnPause.style.display = "none";
});

btnPlay.addEventListener('click', (e) => {

    if(document.getElementById('musica-rodando') !== null) {
        
        e.preventDefault();
        play();
    }
});

let getTime = (milli) => {
    
    let time = new Date(milli);
    let minutes = time.getUTCMinutes();
    let seconds = time.getUTCSeconds();
    
    if(seconds < 10)
        seconds = "0" + seconds;
    return minutes + ":" + seconds;
}

function play() {

    interval = setInterval(() => {
        
        progressBar.style.width = (audioPlayer.currentTime / audioPlayer.duration * 100) + "%";
        currentTime.innerHTML = `<p>`+ getTime(audioPlayer.currentTime * 1000) +`</p>`;
        fullTime.innerHTML = `<p>`+ getTime(audioPlayer.duration * 1000) +`</p>`;
    }, 1000);
    audioPlayer.volume = .05;
    audioPlayer.play();
    fullTime.style.display = "inline-block";
    currentTime.style.display = "inline-block";
    btnPlay.style.display = "none";
    btnPause.style.display = "inline";
}

const playSong = (file) => {

    audioPlayer.innerHTML = `<source id="source-player" src="` + file + `" type="audio/mp3">`;
    audioPlayer.load();
    play();
}

document.querySelectorAll('#main-col-music').forEach(item => {

    item.addEventListener('click', event => {

        let image = item.getAttribute('data-image');
        let artist = item.getAttribute('data-artist');
        let song = item.getAttribute('data-song');
        let file = item.getAttribute('data-file');
        let playerArtistComponent = document.getElementsByClassName('player-artist');

        playerArtistComponent[0].innerHTML = `

            <img id="musica-rodando" src="` + image + `"/>
            <h3>` + song + `<br/><span>` + artist + `<span><h3>
        `;

        playSong(file);
    })
});