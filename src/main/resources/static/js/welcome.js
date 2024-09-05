function promptUser() {
    let username = sessionStorage.getItem('username');
    if (!username) {
        let defaultText = 'Guest';
        username = prompt("What's your name?", defaultText);
        if (username !== null && username.trim() !== '') {
            sessionStorage.setItem('username', username);
            createUserOnServer(username);
            showWelcomeContent(username);
        } else {
            alert('No username provided. Try again.');
            window.location.reload();
        }
    }
}

function createUserOnServer(username) {
    const user = { username: username };
    fetch('/welcome', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => {
        console.log('User created:', data);
        window.location.reload();
    })
    .catch(error => console.error('Error creating user:', error));
}

function joinChannel(channelId) {
    window.location.href = `/channels/${channelId}`;
}

 window.onload = function() {
            let username = sessionStorage.getItem('username');
            if (!username) {
                promptUser(); 
            } else {
                document.getElementById('welcomeContent').style.display = 'block';
                document.getElementById('usernameDisplay').textContent = username;
            }
        };


function showWelcomeContent(username) {
            document.getElementById('usernamePrompt').style.display = 'none'; 
            document.getElementById('welcomeContent').style.display = 'block';
            document.getElementById('usernameDisplay').textContent = username;
        }
