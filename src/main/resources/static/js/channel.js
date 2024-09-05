function checkUsernameAndRedirect() {
    let username = sessionStorage.getItem('username');
    
    if (!username) {
        window.location.href = '/welcome';
    } else {
        const channelId = getChannelIdFromURL();
        setChannelTitle(channelId);
        pollMessages(channelId);
        setupSendMessage(channelId);
    }
}

function getChannelIdFromURL() {
    return window.location.pathname.split('/').pop();
}

function setChannelTitle(channelId) {
    const channelTitleElement = document.getElementById('channel-title');
    const channelNames = {
        'general': 'General',
        'random': 'Random',
        'tech': 'Tech'
    };

    const channelName = channelNames[channelId] || 'Unknown Channel';
    channelTitleElement.textContent = `Channel: ${channelName}`;
}

function pollMessages(channelId) {
    setInterval(() => {
        fetch(`/channels/${channelId}/messages`)
            .then(response => response.json())
            .then(messages => {
                updateMessages(messages);
            })
            .catch(error => console.error('Error fetching messages:', error));
    }, 500);
}

function updateMessages(messages) {
    const messageList = document.getElementById('message-list');
    messageList.innerHTML = ''; 
    messages.forEach(message => {
        const messageItem = document.createElement('li');
        messageItem.textContent = `${message.username}: ${message.content}`;
        messageList.appendChild(messageItem);
    });
}

function sendMessage(channelId) {
    const messageInput = document.getElementById('message-input');
    const content = messageInput.value;
    const username = sessionStorage.getItem('username');
    
    if (content.trim() !== '') {
        const message = {
            content: content,
            username: username
        };
        fetch(`/channels/${channelId}/messages`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        })
        .then(() => {
            messageInput.value = ''; 
        })
        .catch(error => console.error('Error sending message:', error));
    }
}

function setupSendMessage(channelId) {
    document.addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            sendMessage(channelId);
        }
    });
}

window.onload = function() {
    checkUsernameAndRedirect();
};
