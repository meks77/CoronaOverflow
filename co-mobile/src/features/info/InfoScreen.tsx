import React from 'react';
import {ScrollView} from 'react-native';
import {Text} from 'react-native-elements';
import {colors} from '../../styles/Colors';

export class InfoScreen extends React.Component {
    render() {
        return (
            <ScrollView style={{flex: 1, backgroundColor: colors.primary_white, padding: 20}}>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginTop: 20, marginBottom: 10}}>About CoronaOverflow</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}>{"CoronaOverflow provides general guidance about safe conduct in times of coronavirus. Users post experiences, solutions and lifehacks in posts, giving public instructions for others to use. Content is rated by the community, which promotes the display of the best solution and prevents spread of misinformation. Posts are aggregated under labels, allowing for an intuitive sorting and browsing experience for users. Highlighting of trends, like posts from important sources (WHO, ...) is offered."}</Text>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10, marginTop: 40}}>Inspiration</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}>{"Especially in extreme situations, like the one we all are currently in, people become very creative in finding solutions to all kinds of new challenges - this Hackathon is the best example. The pandemic can best be fought by effective exchange of knowldge and experiences. We provide the community driven platform CoronaOverflow to collect and share these ideas in the context of Corona, so they are easily accessible from all over the world.\n\nPeople all over the world face themselves in similar situations through the pandemic and through measures to contain it. Many have developed ingenious solutions to larger or smaller problems they faced, be it in professional or daily life. These Corona 'lifehacks' float around the internet in social media and on websites - we give them a dedicated community driven platform."}</Text>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10, marginTop: 40}}>Contributors</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25}}>{"- Hager Markus\n- Reisenbauer Sarah\n- Sölkner Martin\n- Vojinovic Milan"}</Text>
                <Text style={{color: colors.primary_light_green, fontSize: 25, marginBottom: 10, marginTop: 40}}>Supported by</Text>
                <Text style={{color: colors.dark_grey, fontSize: 17, lineHeight: 25, marginBottom:80}}>{"IT-Services der Sozialversicherung GmbH\nJohann-Böhm-Platz 1\n1020 Vienna, Austria"}</Text>
            </ScrollView>
        );
    }
}
