import {Routes} from "../api/Routes";

export function fetchData(route: string, method: string) {
    return new Promise((resolve, reject) => {
        fetch(Routes.BASEURL + route, {
            method: method
        })
            .then((response) => response.json())
            .then((json) => {
                resolve(json);
            })
            .catch((error) => {
                reject(error);
            });
    });
}

export function postLabel(label: string) {
    return new Promise((resolve, reject) => {
        fetch(Routes.BASEURL + Routes.LABELS, {
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
    });
}
