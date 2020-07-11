import  requests
import json
import sys
# TODO: replace with your own app_id and app_key
app_id = 'a70da39d'
app_key = '366a8c892b641f4a0de1081c482f46bd'
language = 'en'
word_id = sys.argv[1]
url = 'https://od-api.oxforddictionaries.com:443/api/v1/entries/'  + language + '/'  + word_id.lower()
r = requests.get(url, headers = {'app_id' : app_id, 'app_key' : app_key})
pd = json.loads(r.text)
#print(pd)

print(pd['results'][0]['lexicalEntries'][0]['entries'][0]['senses'][0]['definitions'][0])
print(pd['results'][0]['lexicalEntries'][0]['entries'][0]['senses'][0]['examples'][0]['text'])

