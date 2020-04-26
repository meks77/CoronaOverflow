import {Routes} from "../api/Routes";
import {getURL} from "../../data/URL";

export function fetchData(route: string, method: string) {
    return new Promise((resolve, reject) => {
        getURL()
            .then((url: string) => {
                console.log("ROUTE IS ", url)
                fetch(url + route, {
                    method: method
                })
                    .then((response) => response.json())
                    .then((json) => {
                        resolve(json);
                    })
                    .catch((error) => {
                        reject(error);
                    });
            })
    });
}

export function postLabel(label: string) {
    return new Promise((resolve, reject) => {
        getURL()
            .then((url: string) => {
                console.log("ROUTE IS ", url)
                fetch(url + Routes.LABELS, {
                    method: 'POST',
                    headers: {
                        Accept: 'application/json',
                        'Content-Type': 'application/json',
                        "X-CO-LABEL": label
                    },
                })
                    .then((response) => response.json())
                    .then((json) => {
                        resolve(json);
                    })
                    .catch((error) => {
                        reject(error)
                    });
            })
    });
}

export function postPosting(userID: string, label: string, text: string, title: string) {
    return new Promise((resolve, reject) => {
        getURL()
            .then((url: string) => {
                console.log("ROUTE IS ", url)
                fetch(url+ Routes.POSTINGS, {
                    method: 'POST',
                    headers: {
                        Accept: 'application/json',
                        'Content-Type': 'application/json',
                        "X-CO-USERID": userID
                    },
                    body: JSON.stringify({
                        label: label,
                        text: text,
                        title: title
                    }),
                })
                    .then((response) => {
                        resolve(response);
                    })
                    .catch((error) => {
                        reject(error)
                    });
            })
    });
}

export function sendVoting(userID: string, route: string) {
    return new Promise((resolve, reject) => {
        getURL()
            .then((url: string) => {
                console.log("ROUTE IS ", url)
                fetch(url + route, {
                    method: 'PUT',
                    headers: {
                        "X-CO-USERID": userID
                    },
                })
                    .then((response) => {
                        resolve(response);
                    })
                    .catch((error) => {
                        reject(error)
                    });
            })
    });
}
