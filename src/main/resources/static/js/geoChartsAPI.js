
google.charts.load('current', {
    callback: function () {
        // Request all the countries there are in restcountries api with the info we want
        fetch('https://restcountries.com/v3.1/all?fields=name,flags,capital,population,currencies,languages,continents')
            .then(response => response.json())

            .then(data => {

                //add countries that bug with Google geoCharts because of their name/code
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/mk.png","svg":"https://flagcdn.com/mk.svg","alt":"The flag of North Macedonia has a red field, at the center of which is a golden-yellow sun with eight broadening rays that extend to the edges of the field."},"name":{"common":"MK","official":"Republic of North Macedonia","nativeName":{"mkd":{"official":"Република Северна Македонија","common":"Македонија"}}},"currencies":{"MKD":{"name":"denar","symbol":"den"}},"capital":["Skopje"],"languages":{"mkd":"Macedonian"},"population":2077132,"continents":["Europe"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/cz.png","svg":"https://flagcdn.com/cz.svg","alt":"The flag of Czechia is composed of two equal horizontal bands of white and red, with a blue isosceles triangle superimposed on the hoist side of the field. The triangle has its base on the hoist end and spans about two-fifth the width of the field."},"name":{"common":"Czech Republic","official":"Czech Republic","nativeName":{"ces":{"official":"Česká republika","common":"Česko"},"slk":{"official":"Česká republika","common":"Česko"}}},"currencies":{"CZK":{"name":"Czech koruna","symbol":"Kč"}},"capital":["Prague"],"languages":{"ces":"Czech","slk":"Slovak"},"population":10698896,"continents":["Europe"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/cd.png","svg":"https://flagcdn.com/cd.svg","alt":"The flag of the Democratic Republic of the Congo has a sky-blue field with a yellow-edged red diagonal band that extends from the lower hoist-side corner to the upper fly-side corner of the field. A large five-pointed yellow star is situated above the diagonal band on the upper hoist side of the field."},"name":{"common":"CD","official":"Democratic Republic of the Congo","nativeName":{"fra":{"official":"République démocratique du Congo","common":"RD Congo"},"kon":{"official":"Repubilika ya Kongo Demokratiki","common":"Repubilika ya Kongo Demokratiki"},"lin":{"official":"Republiki ya Kongó Demokratiki","common":"Republiki ya Kongó Demokratiki"},"lua":{"official":"Ditunga dia Kongu wa Mungalaata","common":"Ditunga dia Kongu wa Mungalaata"},"swa":{"official":"Jamhuri ya Kidemokrasia ya Kongo","common":"Jamhuri ya Kidemokrasia ya Kongo"}}},"currencies":{"CDF":{"name":"Congolese franc","symbol":"FC"}},"capital":["Kinshasa"],"languages":{"fra":"French","kon":"Kikongo","lin":"Lingala","lua":"Tshiluba","swa":"Swahili"},"population":108407721,"continents":["Africa"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/cg.png","svg":"https://flagcdn.com/cg.svg","alt":"The flag of the Republic of the Congo features a yellow diagonal band that extends from the lower hoist-side corner to the upper fly-side corner of the field. Above and beneath this band are a green and red triangle respectively."},"name":{"common":"CG","official":"Republic of the Congo","nativeName":{"fra":{"official":"République du Congo","common":"République du Congo"},"kon":{"official":"Repubilika ya Kongo","common":"Repubilika ya Kongo"},"lin":{"official":"Republíki ya Kongó","common":"Republíki ya Kongó"}}},"currencies":{"XAF":{"name":"Central African CFA franc","symbol":"Fr"}},"capital":["Brazzaville"],"languages":{"fra":"French","kon":"Kikongo","lin":"Lingala"},"population":5657000,"continents":["Africa"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/ss.png","svg":"https://flagcdn.com/ss.svg","alt":"The flag of South Sudan is composed of three equal horizontal bands of black, red with white top and bottom edges, and green. A blue equilateral triangle which spans about two-fifth the width of the field is superimposed on the hoist side with its base on the hoist end of the field. At the center of this triangle is a five-pointed yellow star."},"name":{"common":"SS","official":"Republic of South Sudan","nativeName":{"eng":{"official":"Republic of South Sudan","common":"South Sudan"}}},"currencies":{"SSP":{"name":"South Sudanese pound","symbol":"£"}},"capital":["Juba"],"languages":{"eng":"English"},"population":11193729,"continents":["Africa"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/xk.png","svg":"https://flagcdn.com/xk.svg","alt":""},"name":{"common":"XK","official":"Republic of Kosovo","nativeName":{"sqi":{"official":"Republika e Kosovës","common":"Kosova"},"srp":{"official":"Република Косово","common":"Косово"}}},"currencies":{"EUR":{"name":"Euro","symbol":"€"}},"capital":["Pristina"],"languages":{"sqi":"Albanian","srp":"Serbian"},"population":1775378,"continents":["Europe"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/sz.png","svg":"https://flagcdn.com/sz.svg","alt":"The flag of Eswatini is composed of three horizontal bands — a large central yellow-edged red band, and a light blue band above and beneath the red band. The red band is three times the height of the blue bands and bears a centered emblem made up of a large black and white Nguni shield covering two spears and a staff decorated with feather tassels, all placed horizontally."},"name":{"common":"SZ","official":"Kingdom of Eswatini","nativeName":{"eng":{"official":"Kingdom of Eswatini","common":"Eswatini"},"ssw":{"official":"Umbuso weSwatini","common":"eSwatini"}}},"currencies":{"SZL":{"name":"Swazi lilangeni","symbol":"L"},"ZAR":{"name":"South African rand","symbol":"R"}},"capital":["Mbabane"],"languages":{"eng":"English","ssw":"Swazi"},"population":1160164,"continents":["Africa"]}'))
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/tl.png","svg":"https://flagcdn.com/tl.svg","alt":"The flag of Timor-Leste has a red field with two isosceles triangles which share a common base on the hoist end. The smaller black triangle, which bears a five-pointed white star at its center and spans one-third the width of the field, is superimposed on the larger yellow triangle that extends to the center of the field."},"name":{"common":"TL","official":"Democratic Republic of Timor-Leste","nativeName":{"por":{"official":"República Democrática de Timor-Leste","common":"Timor-Leste"},"tet":{"official":"Repúblika Demokrátika Timór-Leste","common":"Timór-Leste"}}},"currencies":{"USD":{"name":"United States dollar","symbol":"$"}},"capital":["Dili"],"languages":{"por":"Portuguese","tet":"Tetum"},"population":1318442,"continents":["Oceania"]}'));
                data.push(JSON.parse('{"flags":{"png":"https://flagcdn.com/w320/re.png","svg":"https://flagcdn.com/re.svg","alt":""},"name":{"common":"RE","official":"Réunion Island","nativeName":{"fra":{"official":"Ile de la Réunion","common":"RE"}}},"currencies":{"EUR":{"name":"Euro","symbol":"€"}},"capital":["Saint-Denis"],"languages":{"fra":"French"},"population":840974,"continents":["Africa"]}'))

                // geoCharts array used to display the countries, used in google.visualization.arrayToDataTable(dataArray)
                let dataArray = [];
                dataArray.push(['Country', 'Value', { role: 'tooltip', p: { html: true } }]);

                // Filter variables
                let selectedContinent = null;
                let selectedLanguage = null;
                let selectedPopulation = null;
                let populationCount = null;


                let view = null; // Declare the view variable
                data.forEach(country => {
                    let flagUrl = country.flags.png;
                    let officialName = country.name.official;
                    let commonName = country.name.common;
                    let population = country.population;
                    let continents = country.continents;
                    let capital = country.capital[0];
                    let languages = Object.values(country.languages).join(', ');
                    let currencies = Object.keys(country.currencies).join(', ');

                    let tooltipContent = '<img width="75%" height="75%" src="' + flagUrl + '" alt="Flag of ' + officialName + '">' +
                        '<p>Official Name: ' + officialName + '</p>' +
                        '<p>Population: ' + population + '</p>' +
                        '<p>Capital: ' + capital + '</p>' +
                        '<p>Languages: ' + languages + '</p>' +
                        '<p>Currencies: ' + currencies + '</p>' +
                        '<p>Continent: ' + continents + '</p>';

                    dataArray.push([commonName, 0, tooltipContent]);
                    let viewInitialData = google.visualization.arrayToDataTable(dataArray);
                    view = new google.visualization.DataView(viewInitialData);
                });


                function applyFilters(type) {
                    //This is the first line of dataArray, it specifies the columns and set the last one to accept html as a string.
                    dataArray.length = 0;
                    dataArray.push(['Country', 'Value', { role: 'tooltip', p: { html: true } }]);
                    populationCount = 0;
                    data.forEach(country => {
                        let flagUrl = country.flags.png;
                        let officialName = country.name.official;
                        let commonName = country.name.common;
                        let population = country.population;
                        let continents = country.continents;

                        // Capital needs to be capital[0] because it's a list and some countries have multiple capitals,
                        // a good example is Bolivia, which has La Paz and Sucre as capitals
                        let capital = country.capital[0];

                        //Currencies and language work just like the capital, but in this case there are JSON objects
                        //We need the "values" of languages because we want the full name, ex: "por": "portuguese". if
                        //we wanted "por" instead of portuguese it would be keys.
                        let languages = Object.values(country.languages).join(', ');

                        //I think currencies are better known for their keys like EUR for euro, but we can change it in the future
                        let currencies = Object.keys(country.currencies).join(', ');


                        //this is the tooltip you see at the first row of dataArray, we are passing the
                        let tooltipContent = '<img width="75%" height="75%" src="' + flagUrl + '" alt="Flag of ' + officialName + '">' +
                            '<p>Official Name: ' + officialName + '</p>' +
                            '<p>Population: ' + population + '</p>' +
                            '<p>Capital: ' + capital + '</p>' +
                            '<p>Languages: ' + languages + '</p>' +
                            '<p>Currencies: ' + currencies + '</p>' +
                            '<p>Continent: ' + continents + '</p>';

                        let value = 0;
                        if (type === "Continent"){
                            if (!selectedContinent || continents.includes(selectedContinent)) {
                                value = 200;
                                populationCount += population;
                            }
                        }else if (type === "Language") {
                            if (!selectedLanguage || languages.includes(selectedLanguage)) {
                                value = 200;
                                populationCount += population;

                            }
                        } else if (type === "Population") {
                            if (!selectedPopulation || population > selectedPopulation) {
                                value = 200;
                                populationCount += population;
                            }
                        }

                        dataArray.push([commonName, value, tooltipContent]);


                    });
                    //Creates the table with dataArray, and set the view
                    let viewData = google.visualization.arrayToDataTable(dataArray);
                    view = new google.visualization.DataView(viewData);

                    const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
                    const appendAlert = (message, type) => {
                        const wrapper = document.createElement('div')
                        wrapper.innerHTML = [
                            `<div class="alert alert-${type} alert-dismissible" role="alert">`,
                            `   <div>${message}</div>`,
                            '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
                            '</div>'
                        ].join('')

                        alertPlaceholder.append(wrapper)
                    }
                    appendAlert('Total population: ' + populationCount, 'info')
                    console.log(populationCount);

                    resizeChart()
                }

                //Filters By Continent
                document.getElementById('filterSouthAmerica').addEventListener('click', function () {
                    selectedContinent = 'South America';
                    applyFilters('Continent');
                });
                document.getElementById('filterNorthAmerica').addEventListener('click', function () {
                    selectedContinent = 'North America';
                    applyFilters('Continent');
                });
                document.getElementById('filterEurope').addEventListener('click', function () {
                    selectedContinent = 'Europe';
                    applyFilters('Continent');
                });
                document.getElementById('filterAsia').addEventListener('click', function () {
                    selectedContinent = 'Asia';
                    applyFilters('Continent');
                });
                document.getElementById('filterAfrica').addEventListener('click', function () {
                    selectedContinent = 'Africa';
                    applyFilters('Continent');
                });
                document.getElementById('filterOceania').addEventListener('click', function () {
                    selectedContinent = 'Oceania';
                    applyFilters('Continent');
                });


                //Filter by Languages
                document.getElementById('filterEnglish').addEventListener('click', function () {
                    selectedLanguage = 'English';
                    applyFilters('Language');
                });
                document.getElementById('filterArabic').addEventListener('click', function () {
                    selectedLanguage = 'Arabic';

                    applyFilters('Language');
                });
                document.getElementById('filterFrench').addEventListener('click', function () {
                    selectedLanguage = 'French';
                    applyFilters('Language');
                });
                document.getElementById('filterPortuguese').addEventListener('click', function () {
                    selectedLanguage = 'Portuguese';
                    applyFilters('Language');
                });
                document.getElementById('filterSpanish').addEventListener('click', function () {
                    selectedLanguage = 'Spanish';
                    applyFilters('Language');
                });


                // Filter By Population
                document.getElementById('filterOver10M').addEventListener('click', function () {
                    selectedPopulation = 10000000;
                    applyFilters('Population');
                });
                document.getElementById('filterOver50M').addEventListener('click', function () {
                    selectedPopulation = 50000000;
                    applyFilters('Population');
                });
                document.getElementById('filterOver100M').addEventListener('click', function () {
                    selectedPopulation = 100000000;
                    applyFilters('Population');
                });
                document.getElementById('filterOver200M').addEventListener('click', function () {
                    selectedPopulation = 200000000;
                    applyFilters('Population');
                });


                //Map customization
                let selectedCountry = null;
                let options = {
                    region: 'world',
                    colorAxis: { colors: ['#D3D3D3', '#50C878'] },
                    backgroundColor: '#81d4fa',
                    datalessRegionColor: 'white',
                    defaultColor: '#f5f5f5',
                    enableRegionInteractivity: true,
                    tooltip: {
                        isHtml: true,
                        textStyle: { fontSize: 15, color: 'black', fontName: 'Arial' },
                        trigger: 'focus',
                        opacity: 0.9,
                        borderColor: 'crimson',
                        borderRadius: 5,
                        showColorCode: false,
                        showTitle: true,
                        titleTextStyle: { fontSize: 16, color: 'blue', fontName: 'Arial' },
                    },
                };

                //sets up the map with geoChart, this points to regions_div.
                let chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

                // draws the map (ofc duh)
                function resizeChart() {
                    chart.draw(view, options);
                }

                // Zoom on click cause why not? Basically works by resizing the map when the click happens.
                // and centralize

                //ToDO: maybe change the color of the clicked country because now this is a mess, we don't even know which country we clicked.

                google.visualization.events.addListener(chart, 'regionClick', function (eventData) {
                    let clickedRegion = eventData.region;

                    if (selectedCountry === clickedRegion) {
                        selectedCountry = null;
                        options.region = 'world';
                    } else {
                        selectedCountry = clickedRegion;
                        options.region = clickedRegion;
                    }
                    resizeChart();
                });

                if (window.addEventListener) {
                    window.addEventListener('resize', resizeChart);
                } else if (window.attachEvent) {
                    window.attachEvent('onresize', resizeChart);
                }

                resizeChart();
            });
    },
    packages: ['geochart']
});
// Suffer is finally over LOL